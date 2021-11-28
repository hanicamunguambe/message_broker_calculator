package com.calculator.domain;

import java.math.BigDecimal;

/**
 * @Author Hanica Munguambe
 * @Author 13/11/2021 17:22
 */

public class Calculadora {

    private BigDecimal a, b;

    public Calculadora() {
    }

    public Calculadora(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }

    public BigDecimal geA() {
        return a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }
}
