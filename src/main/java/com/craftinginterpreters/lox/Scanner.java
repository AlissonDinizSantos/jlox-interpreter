package com.craftinginterpreters.lox;

import java.util.ArrayList;
import java.util.List;

class Scanner {
  private final String source;
  private final List<Token> tokens = new ArrayList<>();

  Scanner(String source) {
    this.source = source;
  }

  List<Token> scanTokens() {
    // Por enquanto retorna apenas o token de fim de arquivo
    tokens.add(new Token(TokenType.EOF, "", null, 0)); // Linha fictícia 0
    return tokens;
  }
}