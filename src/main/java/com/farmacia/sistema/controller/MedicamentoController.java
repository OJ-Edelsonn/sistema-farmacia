package com.farmacia.sistema.controller;

import com.farmacia.sistema.model.Medicamento;
import com.farmacia.sistema.service.MedicamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// Controlador MVC: recibe peticiones del navegador y coordina vistas con datos.
@Controller
@RequestMapping
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    // Inyeccion de dependencias por constructor.
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    // Pagina principal del sistema.
    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    // Lista todos los medicamentos.
    @GetMapping("/medicamentos")
    public String listar(Model model) {
        model.addAttribute("medicamentos", medicamentoService.listarTodos());
        return "medicamentos/listar";
    }

    // Muestra el formulario para registrar un nuevo medicamento.
    @GetMapping("/medicamentos/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        model.addAttribute("titulo", "Registrar Medicamento");
        return "medicamentos/formulario";
    }

    // Guarda un medicamento nuevo o editado.
    @PostMapping("/medicamentos/guardar")
    public String guardar(Medicamento medicamento, RedirectAttributes redirectAttributes) {
        medicamentoService.guardar(medicamento);
        redirectAttributes.addFlashAttribute("mensaje", "Medicamento guardado correctamente");
        return "redirect:/medicamentos";
    }

    // Muestra el formulario con los datos de un medicamento existente.
    @GetMapping("/medicamentos/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Medicamento medicamento = medicamentoService.buscarPorId(id);

        if (medicamento == null) {
            redirectAttributes.addFlashAttribute("mensaje", "El medicamento no existe");
            return "redirect:/medicamentos";
        }

        model.addAttribute("medicamento", medicamento);
        model.addAttribute("titulo", "Editar Medicamento");
        return "medicamentos/formulario";
    }

    // Elimina un medicamento por su id.
    @GetMapping("/medicamentos/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        medicamentoService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Medicamento eliminado correctamente");
        return "redirect:/medicamentos";
    }

    // Muestra el detalle de un medicamento.
    @GetMapping("/medicamentos/detalle/{id}")
    public String detalle(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Medicamento medicamento = medicamentoService.buscarPorId(id);

        if (medicamento == null) {
            redirectAttributes.addFlashAttribute("mensaje", "El medicamento no existe");
            return "redirect:/medicamentos";
        }

        model.addAttribute("medicamento", medicamento);
        return "medicamentos/detalle";
    }

    // Busca medicamentos por nombre.
    @GetMapping("/medicamentos/buscar")
    public String buscar(@RequestParam("nombre") String nombre, Model model) {
        model.addAttribute("medicamentos", medicamentoService.buscarPorNombre(nombre));
        model.addAttribute("nombreBuscado", nombre);
        return "medicamentos/listar";
    }
}
