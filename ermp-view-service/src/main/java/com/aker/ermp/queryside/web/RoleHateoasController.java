package com.aker.ermp.queryside.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aker.ermp.common.controller.BaseController;
import com.aker.ermp.common.model.ResourceWithUrl;
import com.aker.ermp.model.Role;
import com.aker.ermp.queryside.backend.domain.RoleViewServiceImpl;

@RestController
@RequestMapping(value = "/roles")
public class RoleHateoasController extends BaseController {

    @Autowired
	private RoleViewServiceImpl roleViewService;

    @RequestMapping(value = "/{role-id}", method = GET)
    public CompletableFuture<ResourceWithUrl> getRole(@PathVariable("role-id") String id) {
        return roleViewService.findById(id).thenApply(this::toResource);
    }

    public ResourceWithUrl toResource(Role role) {
        ResourceWithUrl<Role> result = new ResourceWithUrl<>(role);
        if (role != null) {
            result.setUrl(linkTo(methodOn(RoleHateoasController.class).getRole(role.getId())).withSelfRel().getHref());
        }
        return result;
    }
}
