package com.TiendaII.controller;

import com.TiendaII.domain.Producto;
import com.TiendaII.domain.Categoria;
import com.TiendaII.service.CategoriaService;
import com.TiendaII.service.ProductoService;
import com.TiendaII.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
    
        //Los métodos siguientes son para la prueba de consultas ampliadas
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/pruebas/listado2";
    }

    @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {
        var productos = productoService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @PostMapping("/query2")
    public String consultaQuery2(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {
        var productos = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query3")
    public String consultaQuery3(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {
        var productos = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

    @PostMapping("/buscarExistencias1")
    public String buscarExistencias1(@RequestParam("existenciasMin") int existenciasMin,
            @RequestParam("existenciasMax") int existenciasMax, Model model) {
        var productos = productoService.findByExistenciasBetweenOrderByDescripcion(existenciasMin, existenciasMax);
        model.addAttribute("productos", productos);
        model.addAttribute("existenciasMin", existenciasMin);
        model.addAttribute("existenciasMax", existenciasMax);
        model.addAttribute("totalProductos", productos.size());
        return "/pruebas/listado3";
    }

    @PostMapping("/buscarExistencias2")
    public String buscarExistencias2(@RequestParam("existenciasMin") int existenciasMin,
            @RequestParam("existenciasMax") int existenciasMax, Model model) {
        var productos = productoService.buscarPorExistenciasJPQL(existenciasMin, existenciasMax);
        model.addAttribute("productos", productos);
        model.addAttribute("existenciasMin", existenciasMin);
        model.addAttribute("existenciasMax", existenciasMax);
        model.addAttribute("totalProductos", productos.size());
        return "/pruebas/listado3";
    }

    @PostMapping("/buscarExistencias3")
    public String buscarExistencias3(@RequestParam("existenciasMin") int existenciasMin,
            @RequestParam("existenciasMax") int existenciasMax, Model model) {
        var productos = productoService.buscarPorExistenciasNativo(existenciasMin, existenciasMax);
        model.addAttribute("productos", productos);
        model.addAttribute("existenciasMin", existenciasMin);
        model.addAttribute("existenciasMax", existenciasMax);
        model.addAttribute("totalProductos", productos.size());
        return "/pruebas/listado3";
    }

    // POR ESTO:
    @GetMapping("/listado3")
    public String mostrarListadoExistencias(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        
        model.addAttribute("totalProductos", 0);
        return "/pruebas/listado3";
    }
}
