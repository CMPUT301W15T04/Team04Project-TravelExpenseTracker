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


package ca.ualberta.cs.cmput301w15t04team04project.network.data;

public class SimpleSearchCommand {
	private String user;
	private String status;
	private String tag;
	/**
	 * Initial the search command parameter
	 * @param user
	 * @param status
	 * @param tag
	 */
	public SimpleSearchCommand(String user, String status, String tag) {
		this.user = user;
		this.status = status;
		this.tag = tag;
	}
	
	/**
	 * Covert this to a elastic search command
	 * @return
	 */
	
	public String getJsonCommand() {
		StringBuffer command = new StringBuffer("{\"query\" : {\"bool\" : {\"must\" :[");
		if (user != null){
			command.append("{\"match\" :{\"Claimiant\" : \""+user+"\"}}, ");
		}
		if (status != null){
			command.append("{\"match\" :{\"status\" : \""+status+"\"}}, ");
		}
		if (tag != null){
			command.append("{\"match\" :{\"tags\" : \""+tag+"\"}}, ");
		}
		command.delete(command.length() - 2, command.length());
		command.append(	"] }}}");
		return command.toString();
	}
	
}
