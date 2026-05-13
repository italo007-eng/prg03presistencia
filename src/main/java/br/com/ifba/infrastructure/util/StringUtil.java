/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author Italo
 */
/**
 * Classe utilitária para validações de Strings.
 * Centraliza as validações comuns usadas nas regras de negócio.
 */
public class StringUtil {
      /**
     * Verifica se uma String é nula ou vazia
     * @param str
     * @return true se for nula ou vazia
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Verifica se uma String tem pelo menos um tamanho mínimo
     * @param str
     * @param minLength
     * @return true se tiver o tamanho mínimo
     */
    public static boolean hasMinLength(String str, int minLength) {
        if (isNullOrEmpty(str)) return false;
        return str.trim().length() >= minLength;
    }

    /**
     * Verifica se uma String não ultrapassa um tamanho máximo
     * @param str
     * @param maxLength
     * @return true se estiver dentro do limite
     */
    public static boolean hasMaxLength(String str, int maxLength) {
        if (isNullOrEmpty(str)) return false;
        return str.trim().length() <= maxLength;
    }
}
