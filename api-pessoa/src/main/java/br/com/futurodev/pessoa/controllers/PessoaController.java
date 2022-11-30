package br.com.futurodev.pessoa.controllers;

import br.com.futurodev.pessoa.model.Pessoa;
import br.com.futurodev.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> register(@RequestBody Pessoa pessoa){
        Pessoa person= pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(person, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
        Pessoa person= pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(person, HttpStatus.OK);
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<Pessoa> search (@PathVariable (value = "idPessoa")Long idPessoa){
        Pessoa person = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<Pessoa>(person, HttpStatus.OK);
    }

    @DeleteMapping(value = "/", produces = "application/json")
    public ResponseEntity<String> delete(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Cadastro deletado", HttpStatus.OK);
    }

    @GetMapping(value = "/buscarNome", produces = "application/json")
    public ResponseEntity<List<Pessoa>> getPessoaById(@RequestParam (name = "nome") String nome){
        List<Pessoa> pessoas = pessoaRepository.getPessoaByName(nome);
        return new ResponseEntity<List<Pessoa>>(pessoas,HttpStatus.OK);
    }
}
