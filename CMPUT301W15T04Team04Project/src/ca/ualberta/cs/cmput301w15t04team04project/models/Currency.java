/*
 * Copyright 2015 Weijie Sun
 * Copyright 2015 Youdong Ma
 * Copyright 2015 Yufei Zhang
 * Copyright 2015 Chenrui Lei
 * Copyright 2015 Yang Zhang
 * Copyright 2015 Ji Yang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.ualberta.cs.cmput301w15t04team04project.models;

/**
 * Class Currency is use to represent the currency. Each Currency object has a
 * type and an amount. The type will represent the unit of a currency. The
 * amount will represent the amount it.
 *
 * @author Chenrui Lei
 * @version 1.0
 * @since 2015-03-14
 */
public class Currency {
	private String type;
	private double amount;

	public Currency(String type, double d) {
		this.setType(type);
		this.setAmount(d);
	}

	public Currency(String type) {
		this.setType(type);
		this.setAmount(0);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return this.type + this.amount;
	}

	public boolean isSameType(Currency currency) {
		return this.type.equals(currency.getType());
	}
}
