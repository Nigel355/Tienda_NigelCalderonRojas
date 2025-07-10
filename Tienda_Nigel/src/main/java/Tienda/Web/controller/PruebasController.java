/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.controller;
import Tienda.Web.domain.Categoria;
import Tienda.Web.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Tienda.Web.service.ProductoService;
/**
 *
 * @author nigel
 */
@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
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
     @GetMapping("/listado2")
    public String listado2(Model model) {
    model.addAttribute("productos", productoService.findByPrecioBetweenOrderByDescripcion(0, 15));
    return "/pruebas/listado2";
}
    @PostMapping("/query1")
public String consultaQuery1(@RequestParam(value = "precioInf") double precioInf,
                             @RequestParam(value = "precioSup") double precioSup, Model model) {
    var productos = productoService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    model.addAttribute("productos", productos);
    model.addAttribute("precioInf", precioInf);
    model.addAttribute("precioSup", precioSup);
    return "/consulta/listado";
}
@PostMapping("/query2")
public String consultaQuery2(@RequestParam(value = "precioInf") double precioInf,
                            @RequestParam(value = "precioSup") double precioSup,
                            Model model) {
    var productos = productoService.metodoJPQL(precioInf, precioSup);
    model.addAttribute("productos", productos);
    model.addAttribute("totalProductos", productos.size());
    model.addAttribute("precioInf", precioInf);
    model.addAttribute("precioSup", precioSup);
    return "/pruebas/listado2";
}

@PostMapping("/query3")
public String consultaQuery3(@RequestParam(value = "precioInf") double precioInf,
                            @RequestParam(value = "precioSup") double precioSup,
                            Model model) {
    var productos = productoService.metodoNativo(precioInf, precioSup);
    model.addAttribute("productos", productos);
    model.addAttribute("totalProductos", productos.size());
    model.addAttribute("precioInf", precioInf);
    model.addAttribute("precioSup", precioSup);
    return "/pruebas/listado2";
}
}
