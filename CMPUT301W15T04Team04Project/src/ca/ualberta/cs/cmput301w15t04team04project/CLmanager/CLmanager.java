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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.StringEntity;

import android.util.Log;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.network.data.Hits;
import ca.ualberta.cs.cmput301w15t04team04project.network.data.SearchHit;
import ca.ualberta.cs.cmput301w15t04team04project.network.data.SearchResponse;
import ca.ualberta.cs.cmput301w15t04team04project.network.data.SimpleSearchCommand;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author youdong
 * 
 */
public class CLmanager {
	private static final String RESOURCE_URL = "http://cmput301.softwareprocess.es:8080/cmput301w15t04/claim/";
	private static final String SEARCH_URL = "http://cmput301.softwareprocess.es:8080/cmput301w15t04/claim/_search";
	private static Gson gson;
	private static HttpClient httpClient = new DefaultHttpClient();
	private static final String TAG = "ClaimSearch";

	/**
	 * 
	 */
	public CLmanager() {
		gson = new Gson();
	}

	/**
	 * @author youdong
	 * @param claim
	 * @param string
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public void insertClaim(Claim claim) throws IllegalStateException,
			IOException {
		HttpPost addRequest = new HttpPost(RESOURCE_URL + claim.getClaim());
		StringEntity stringEntity = null;
		try {
			stringEntity = new StringEntity(gson.toJson(claim));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addRequest.setEntity(stringEntity);
		HttpResponse addResponse = null;
		try {
			addResponse = httpClient.execute(addRequest);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author youdong
	 * @param claimId
	 */
	public void deleteClaim(String claimName) {
		HttpDelete deleteRequest = new HttpDelete(RESOURCE_URL + claimName);
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

	/**
	 * @author youdong
	 * @param claim
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public void updateClaim(Claim claim) throws IllegalStateException,
			IOException {
		HttpPost updateRequest = new HttpPost(RESOURCE_URL + claim.getClaim());
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

	/**
	 * @author youdong
	 * @param string
	 * @return
	 */
	public Claim getClaim(String string) {

		HttpGet getRequest = new HttpGet(RESOURCE_URL + string);
		HttpResponse getResponse;
		try {
			getResponse = httpClient.execute(getRequest);
			String json = getEntityContent(getResponse);
			// We have to tell GSON what type we expect
			Type searchHitType = new TypeToken<SearchHit<Claim>>() {
			}.getType();
			// Now we expect to get a Recipe response
			SearchHit<Claim> esResponse = gson.fromJson(json, searchHitType);
			// We get the recipe from it!
			return esResponse.getSource();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

/*	public SearchResponse<Claim> searchClaimList() {
		ClaimList claimList = new ClaimList();
		ClaimEditController controller = new ClaimEditController(claimList);
		SearchResponse<Claim> esResponse = null;
		try {
			HttpPost searchRequest = new HttpPost(SEARCH_URL);
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(searchRequest);
			esResponse = parseSearchResponse(response);
			Hits<Claim> hits = esResponse.getHits();

			if (hits != null) {
				if (hits.getHits() != null) {
					for (SearchHit<Claim> sesr : hits.getHits()) {
						controller.appendClaim((sesr.getSource()));
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return esResponse;
	}*/

	public ArrayList<Claim> searchClaimList(String userName ,String searchString, String tags) {
		ArrayList<Claim> claims = new ArrayList<Claim>();
		try {
			HttpPost searchRequest = createSearchRequest(userName, searchString, tags);
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(searchRequest);
			SearchResponse<Claim> esResponse = parseSearchResponse(response);
			Hits<Claim> hits = esResponse.getHits();

			if (hits != null) {
				if (hits.getHits() != null) {
					for (SearchHit<Claim> sesr : hits.getHits()) {
						claims.add((sesr.getSource()));
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return claims;
	}
	
	private HttpPost createSearchRequest(String userName ,String searchString, String tags) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		HttpPost searchRequest = new HttpPost(SEARCH_URL);
		SimpleSearchCommand command = new SimpleSearchCommand(userName, searchString, tags);

		String query = command.getJsonCommand();
		Log.i(TAG, "Json command: " + query);

		StringEntity stringEntity;
		stringEntity = new StringEntity(query);

		searchRequest.setHeader("Accept", "application/json");
		searchRequest.setEntity(stringEntity);

		return searchRequest;
	}

	
	/**
	 * @author youdong
	 * @param listID
	 * @param string
	 * @return
	 */
	public ClaimList getClaimList(ArrayList<Long> listID, String string) {
		ClaimList claimList = new ClaimList();
		for (long Id : listID) {
			// claimList.addClaim(getClaim(Id, string));
		}
		return claimList;
	}

	/**
	 * @author youdong
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private SearchResponse<Claim> parseSearchResponse(HttpResponse response)
			throws IOException {
		String json;
		json = getEntityContent(response);

		Type searchResponseType = new TypeToken<SearchResponse<Claim>>() {
		}.getType();

		SearchResponse<Claim> esResponse = gson.fromJson(json,
				searchResponseType);

		return esResponse;
	}

	public static String getEntityContent(HttpResponse response)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			result.append(line);
		}

		return result.toString();
	}
	// private SearchHit<Claim> parseClaimHit(HttpResponse response) {
	// TODO Auto-generated method stub
	// return null;
	// }
}
