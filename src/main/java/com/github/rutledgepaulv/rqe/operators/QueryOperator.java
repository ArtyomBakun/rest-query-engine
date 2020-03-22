/*
 *  com.github.rutledgepaulv.rqe.operators.QueryOperator
 *  *
 *  * Copyright (C) 2016 Paul Rutledge <paul.v.rutledge@gmail.com>
 *  *
 *  * This software may be modified and distributed under the terms
 *  * of the MIT license.  See the LICENSE file for details.
 *
 */

package com.github.rutledgepaulv.rqe.operators;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.RSQLOperators;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.*;

public class QueryOperator {

    public static QueryOperator EQUAL = new QueryOperator(RSQLOperators.EQUAL, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.EQ);
    public static QueryOperator NOT_EQUAL = new QueryOperator(RSQLOperators.NOT_EQUAL, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.NE);
    public static QueryOperator LESS_THAN = new QueryOperator(RSQLOperators.LESS_THAN, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.LT);
    public static QueryOperator LESS_THAN_OR_EQUAL = new QueryOperator(RSQLOperators.LESS_THAN_OR_EQUAL, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.LTE);
    public static QueryOperator GREATER_THAN = new QueryOperator(RSQLOperators.GREATER_THAN, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.GT);
    public static QueryOperator GREATER_THAN_OR_EQUAL = new QueryOperator(RSQLOperators.GREATER_THAN_OR_EQUAL, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.GTE);
    public static QueryOperator IN = new QueryOperator(RSQLOperators.IN, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.IN);
    public static QueryOperator NOT_IN = new QueryOperator(RSQLOperators.NOT_IN, com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.NIN);
    public static QueryOperator EXISTS = new QueryOperator(new ComparisonOperator("=ex="), com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.EX, true);
    public static QueryOperator REGEX = new QueryOperator(new ComparisonOperator("=re="), com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.RE);
    public static QueryOperator SUBQUERY_ANY = new QueryOperator(new ComparisonOperator("=q="), com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator.SUB_CONDITION_ANY, true);

    public static Set<QueryOperator> defaultOperators(){
        return new HashSet<>(asList(
                EQUAL, NOT_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, GREATER_THAN,
                GREATER_THAN_OR_EQUAL, IN, NOT_IN, EXISTS, REGEX, SUBQUERY_ANY
        ));
    }


    private ComparisonOperator parserOperator;
    private com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator qbuilderOperator;
    private boolean doesOperatorDetermineValueType;

    public QueryOperator(ComparisonOperator parserOperator,
                         com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator qbuilderOperator,
                         boolean doesOperatorDetermineValueType) {
        this.parserOperator = parserOperator;
        this.qbuilderOperator = qbuilderOperator;
        this.doesOperatorDetermineValueType = doesOperatorDetermineValueType;
    }

    public QueryOperator(ComparisonOperator parserOperator,
                         com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator qbuilderOperator) {
        this(parserOperator, qbuilderOperator, false);
    }

    public QueryOperator(ComparisonOperator parserOperator, String representation) {
        this(parserOperator,
                new com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator(representation),
                false
        );
    }

    public QueryOperator(ComparisonOperator parserOperator, String representation,
                         boolean doesOperatorDetermineValueType) {
        this(parserOperator,
                new com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator(representation),
                doesOperatorDetermineValueType
        );
    }


    public ComparisonOperator parserOperator() {
        return parserOperator;
    }

    public com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator qbuilderOperator() {
        return qbuilderOperator;
    }

    public boolean doesOperatorDetermineValueType() {
        return doesOperatorDetermineValueType;
    }
}
