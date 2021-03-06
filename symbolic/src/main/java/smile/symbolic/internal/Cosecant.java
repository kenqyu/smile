/*******************************************************************************
 * Copyright (c) 2017 Ernest DeFoy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package smile.symbolic.internal;

/**
 * @author Ernest DeFoy
 */
public class Cosecant extends UnaryNode {

    public Cosecant(Expression exp) {

        super(exp, UnaryOperator.CSC);
    }

    @Override
    public Expression derive() {

        if(exp instanceof Constant)
            return new Constant(0);

        // chain rule
        return new Negation(new Product(
                exp.derive(),
                new Product(
                        new Cotangent(exp),
                        this)
                )
        );
    }

    @Override
    public Expression reduce() {
        return this;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
