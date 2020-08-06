package com.example.demo.controllersImpl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.PermisoSolicitudController;
import com.example.demo.entities.Empleado;
import com.example.demo.entities.Permiso;
import com.example.demo.entities.PermisoSolicitud;
import com.example.demo.entities.Solicitud;
import com.example.demo.entities.User;
import com.example.demo.requests.AddPermisoSolicitud;
import com.example.demo.requests.FillPermisoSolicitud;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.PermisoService;
import com.example.demo.service.PermisoSolicitudService;
import com.example.demo.service.SolicitudService;
import com.example.demo.service.UserService;


@RestController
public class PermisoSolicitudControllerImpl implements PermisoSolicitudController {
	@Autowired
	PermisoSolicitudService permisoSolicitudService;
	@Autowired
	SolicitudService solicitudService;
	@Autowired
	PermisoService permisoService;
	@Autowired
	UserService userService;
	@Autowired
	EmpleadoService empleadoService;


	// http://localhost:8888/permisoSolicituds (GET)
	@RequestMapping(value = "/permisoSolicituds", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "*")
	@Override
	public List<PermisoSolicitud> getPermisoSolicituds() {
		return permisoSolicitudService.findAllPermisoSolicituds();
	}


	// http://localhost:8888/permisoSolicituds/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<PermisoSolicitud> getPermisoSolicitudById(@PathVariable Long id) {
		return permisoSolicitudService.findPermisoSolicitudById(id);
	}


	// http://localhost:8888/permisoSolicituds/add (ADD)
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/permisoSolicituds/add", method = RequestMethod.POST, produces = "application/json")
	public PermisoSolicitud addPermisoSolicitud(@RequestBody AddPermisoSolicitud solicitud) {

		Solicitud newSol = new Solicitud();
		PermisoSolicitud pSol = new PermisoSolicitud();

		newSol.setStatus(solicitud.status);
		newSol.setType(solicitud.type);
		newSol.setFechaCreacion(solicitud.fechaCreacion);
		Optional<User> user = userService.findUserById(solicitud.iduser);
		newSol.setUser(user.get());
		Solicitud savedSol = solicitudService.saveSolicitud(newSol);
		pSol.setSolicitud(savedSol);
		Optional<Permiso> permiso = permisoService.findPermisoById(Integer.toUnsignedLong(1));
		pSol.setPermiso(permiso.get());
		pSol.setFrom(solicitud.from);
		pSol.setTo(solicitud.to);
		return permisoSolicitudService.savePermisoSolicitud(pSol);
	}


	// http://localhost:8888/permisoSolicituds/delete/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deletePermisoSolicitud(@PathVariable Long id) {
		return permisoSolicitudService.deletePermisoSolicitud(id);
	}


	// http://localhost:8888/permisoSolicituds/update (PATCH)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updatePermisoSolicitud(PermisoSolicitud permisoSolicitudNew) {
		return permisoSolicitudService.updatePermisoSolicitud(permisoSolicitudNew);
	}

	@RequestMapping(value = "/permisoSolicituds/fill/{id}", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "*")
	@Override
    public PermisoSolicitud fillPermisoSolicitud(@PathVariable Long id, @RequestBody FillPermisoSolicitud solicitud) {
        Optional<PermisoSolicitud> optpSol = permisoSolicitudService.findPermisoSolicitudById(id);
        PermisoSolicitud pSol = optpSol.get();

        Solicitud sol = pSol.getSolicitud();
        sol.setFechaResolucion(solicitud.fecha);
        sol.setStatus(solicitud.response);
        if(solicitud.response == 2) {
    		Empleado updEmpleado = sol.getUser().getEmpleado();
    		int dias = pSol.getTo().subtract(pSol.getFrom()).divide(BigInteger.valueOf(Integer.toUnsignedLong(24*60*60*1000))).intValue();
    		updEmpleado.setDiasRestantes(updEmpleado.getDiasRestantes() - dias);
    		empleadoService.updateEmpleado(updEmpleado);
    		User updUser = sol.getUser();
    		updUser.setEmpleado(updEmpleado);
    		sol.setUser(updUser);
        }
        String solUpdResponse = solicitudService.updateSolicitud(sol);
        System.out.println(solUpdResponse);
        pSol.setSolicitud(sol);
        String response = permisoSolicitudService.updatePermisoSolicitud(pSol);
        System.out.println(response);
        return pSol;
    }
	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/permisoSolicituds/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
