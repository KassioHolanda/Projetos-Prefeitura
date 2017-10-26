package br.com.consultassmt.smt_consultas.exceptions;

/**
 * Created by Kassio on 02/10/2017.
 */

public class CpfInvalidoException extends Exception {
    public CpfInvalidoException() {
        super("CPF Invalido");
    }
}
