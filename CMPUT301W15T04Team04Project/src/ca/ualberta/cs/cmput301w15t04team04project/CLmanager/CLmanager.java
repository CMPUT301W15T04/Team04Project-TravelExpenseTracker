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
package ca.ualberta.cs.cmput301w15t04team04project.CLmanager;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;

import com.google.gson.Gson;

public class CLmanager {
	private static final String RESOURCE_URL = "http://cmput301.softwareprocess.es:8080/cmput301w15t04/claimList/";

	private Gson gson;

	public CLmanager() {
		gson = new Gson();
	}

	public ClaimList getClaimList() {
		ClaimList claimList = new ClaimList();
		return claimList;
	}

	public static Claim getClaim(long ID) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(RESOURCE_URL + ID);
		
		HttpResponse response;
		Claim claim = null;
		try {
			response = httpClient.execute(httpGet);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claim;
	}

	public ClaimList getQuestionList(ArrayList<Long> listID) {
		ClaimList cliamList = new ClaimList();
		for (long ID : listID) {
			cliamList.addClaim(getClaim(ID));
		}
		return cliamList;
	}

	//private SearchHit<Claim> parseClaimHit(HttpResponse response) {
		// TODO Auto-generated method stub
	//	return null;
	//}
}
