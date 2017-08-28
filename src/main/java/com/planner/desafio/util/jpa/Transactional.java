package com.planner.desafio.util.jpa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Anotação utilitária para anotar métodos que contém processos de transações de persistência. A anotação
 * indica ao CDI que o método deve ser invocado dentro de uma transação.
 * 
 * A classe responsável pelo binding da transação também deve ser anotada por esta anotação, e deve conter
 * um método anotado por (AroundInvoke) que recebe uma instância de (InvocationContext).
 * 
 * @author Gilmar Carlos
 *
 */
@InterceptorBinding
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactional {

}
