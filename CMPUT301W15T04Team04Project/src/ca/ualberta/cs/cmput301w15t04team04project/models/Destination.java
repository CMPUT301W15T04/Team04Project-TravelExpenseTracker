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
 * The Destination model is a rough Destination's information simply store set
 * and get all of the Destination
 * 
 * @author Weijie Sun
 * @author Ji Yang
 * @version 1.1
 * @since 2015-03-12
 */

public class Destination {
	protected String dName;
	protected String dReason;

	public Destination(String dName) {
		this.dName = dName;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdReason() {
		return dReason;
	}

	public void setdReason(String dReason) {
		this.dReason = dReason;
	}
	
	@Override
	public String toString(){
		return dName;
	}

}
