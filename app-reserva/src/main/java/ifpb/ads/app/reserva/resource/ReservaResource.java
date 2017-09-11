/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.resource;

import ifpb.ads.app.reserva.domain.Reserva;
import ifpb.ads.app.reserva.service.ReservaService;
import java.net.URI;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.GenericEntity;
import java.util.List;

/**
 *
 * @author kieckegard
 */
@RequestScoped
@Path("reserva")
public class ReservaResource {

    @Inject
    private ReservaService reservaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {

        List<Reserva> reservas = this.reservaService.listAll();
        GenericEntity<List<Reserva>> entity = 
                new GenericEntity<List<Reserva>>(reservas){};

        return Response.ok(entity).build();
    }

    @GET
    @Path("{livroId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(
            @DefaultValue("-1")
            @PathParam("livroId") Long reservaId) {

        Reserva found = reservaService.findById(reservaId);
        return Response.ok(found).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(ReservaDTO reservaDTO, @Context UriInfo uriInfo) {

        Reserva created = this.reservaService.add(reservaDTO.getLivroId(),
                reservaDTO.getCliente(), reservaDTO.getDiasEntrega());

        UriBuilder builder = uriInfo.getBaseUriBuilder();

        URI uri = builder.path(ReservaResource.class)
                .path(String.valueOf(created.getId()))
                .build();

        return Response.created(uri).build();
    }

    @DELETE
    @Path("{reservaId}")
    public Response finalizar(
            @DefaultValue("-1")
            @PathParam("reservaId") Long reservaId) {

        reservaService.finalizar(reservaId);
        return Response.ok().build();
    }
}
