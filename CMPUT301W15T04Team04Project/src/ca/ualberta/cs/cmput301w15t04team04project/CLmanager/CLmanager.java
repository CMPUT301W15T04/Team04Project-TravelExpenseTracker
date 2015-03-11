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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.entity.StringEntity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;

import com.google.gson.Gson;

public class CLmanager {
	private static final String RESOURCE_URL = "http://cmput301.softwareprocess.es:8080/cmput301w15t04/";
	private Gson gson = new Gson();
	private static HttpClient httpClient = new DefaultHttpClient();

	public CLmanager() {
		gson = new Gson();
	}

	public void insertClaim(Claim claim, String string)
			throws IllegalStateException, IOException {
		HttpPost httpPost = new HttpPost(RESOURCE_URL + string + "/"
				+ claim.getStartDate().getTime());
		StringEntity stringEntity = null;
		try {
			stringEntity = new StringEntity(gson.toJson(claim));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpPost.setHeader("Accept", "application/json");
		httpPost.setEntity(stringEntity);
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteClaim(long questionId) {
		HttpDelete deleteRequest = new HttpDelete(RESOURCE_URL + questionId);
		deleteRequest.setHeader("Accept", "application/json");
		HttpResponse deleteResponse = null;
		try {
			deleteResponse = httpClient.execute(deleteRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateClaim(Claim claim) throws IllegalStateException,
			IOException {
		HttpPost updateRequest = new HttpPost(RESOURCE_URL + "waitingList"
				+ "/" + claim.getStartDate().getTime());
		StringEntity stringEntity = null;
		try {
			stringEntity = new StringEntity(gson.toJson(claim));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateRequest.setHeader("Accept", "application/json");
		updateRequest.setEntity(stringEntity);
		HttpResponse postResponse = null;
		try {
			postResponse = httpClient.execute(updateRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Claim getClaim(long ID, String string) {

		HttpGet getRequest = new HttpGet(RESOURCE_URL + string + "/" + ID);
		getRequest.setHeader("Accept", "application/json");
		HttpResponse getResponse;
		Claim claim = null;
		try {
			getResponse = httpClient.execute(getRequest);
			// We have to tell GSON what type we expect
			/*Type elasticSearchResponseType = new TypeToken<ElasticSearchResponse<Recipe>>() {
			}.getType();
			// Now we expect to get a Recipe response
			ElasticSearchResponse<Recipe> esResponse = gson.fromJson(json,
					elasticSearchResponseType);
			// We get the recipe from it!
			claim = esResponse.getSource();*/
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claim;
	}

	public ClaimList getClaimList(ArrayList<Long> listID, String string) {
		ClaimList claimList = new ClaimList();
		for (long Id : listID) {
			claimList.addClaim(getClaim(Id, string));
		}
		return claimList;
	}
	// private SearchHit<Claim> parseClaimHit(HttpResponse response) {
	// TODO Auto-generated method stub
	// return null;
	// }
}
