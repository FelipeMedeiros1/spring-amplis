package medeiros.felipe.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.AVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.AVistaEOpcoesRepository;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosAtualizacaoAVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosCadastroAVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosDetalheAVistaEOpcoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("aVistaEOpcoes")
//@SecurityRequirement(name = "bearer-key")
public class AVistaEOpcoesController {
    @Autowired
    AVistaEOpcoesRepository aVistaEOpcoesRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAVistaEOpcoes dados, UriComponentsBuilder criaUri) {
        var aVistaEOpcoes = new AVistaEOpcoes(dados);
        aVistaEOpcoesRepository.save(aVistaEOpcoes);

        var uri = criaUri.path("/aVistaEOpcoes/{id}").buildAndExpand(aVistaEOpcoes.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalheAVistaEOpcoes(aVistaEOpcoes));
    }

    @GetMapping()
    public ResponseEntity<Page<DadosDetalheAVistaEOpcoes>> consultar(@PageableDefault(size = 10, sort = {"carteira"}) Pageable paginacao) {
        var pagina = aVistaEOpcoesRepository.findAll(paginacao).map(DadosDetalheAVistaEOpcoes::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(new DadosDetalheAVistaEOpcoes(aVistaEOpcoesRepository.getReferenceById(id)));
    }

    @GetMapping("consulta/{carteira}")
    public ResponseEntity detalharPorCarteira(@PathVariable String carteira) {
        List<AVistaEOpcoes> avistaEOpcoesPorCarteira = aVistaEOpcoesRepository.findByCarteira(carteira);
        List<DadosDetalheAVistaEOpcoes> detalhesPorCarteira = avistaEOpcoesPorCarteira.stream()
                .map(DadosDetalheAVistaEOpcoes::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(detalhesPorCarteira);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAVistaEOpcoes dados) {
        var aVistaEOpcoes = aVistaEOpcoesRepository.getReferenceById(dados.id());
        aVistaEOpcoes.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalheAVistaEOpcoes(aVistaEOpcoes));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        aVistaEOpcoesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
