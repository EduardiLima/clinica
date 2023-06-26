package br.com.tech4me.clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.clinica.model.DadosMedicos;

@RestController
@RequestMapping("/medicos")

public class MedicosController {

    List<DadosMedicos> medicos = new ArrayList<>();

    @GetMapping
    private List<DadosMedicos> obterListaMedicos() {
        return medicos;
    }
    @GetMapping("/{nome}")
    private String requisicaoComParametro(@PathVariable String nome) {
        return String.format("Página com informação da Dr(a) %s", nome);
    }
    @PostMapping
    private String requisicaoPost(@RequestBody DadosMedicos dadosMedico) {
        medicos.add(dadosMedico);
        return String.format("Requisição post dados do médico: %s", dadosMedico);

    }
}
