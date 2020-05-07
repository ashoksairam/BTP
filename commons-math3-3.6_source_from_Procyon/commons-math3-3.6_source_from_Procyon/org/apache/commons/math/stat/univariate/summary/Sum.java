// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.math.stat.univariate.summary;

import java.io.Serializable;
import org.apache.commons.math.stat.univariate.AbstractStorelessUnivariateStatistic;

public class Sum extends AbstractStorelessUnivariateStatistic implements Serializable
{
    static final long serialVersionUID = -8231831954703408316L;
    private int n;
    private double value;
    
    public Sum() {
        this.n = 0;
        this.value = Double.NaN;
    }
    
    public void increment(final double d) {
        if (Double.isNaN(this.value)) {
            this.value = d;
        }
        else {
            this.value += d;
        }
        ++this.n;
    }
    
    public double getResult() {
        return this.value;
    }
    
    public double getN() {
        return this.n;
    }
    
    public void clear() {
        this.value = Double.NaN;
        this.n = 0;
    }
    
    public double evaluate(final double[] values, final int begin, final int length) {
        double sum = Double.NaN;
        if (this.test(values, begin, length)) {
            sum = 0.0;
            for (int i = begin; i < begin + length; ++i) {
                sum += values[i];
            }
        }
        return sum;
    }
}