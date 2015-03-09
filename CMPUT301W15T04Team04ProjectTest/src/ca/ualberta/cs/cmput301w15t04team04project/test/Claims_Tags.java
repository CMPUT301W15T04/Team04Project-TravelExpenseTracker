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
package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Approval;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import junit.framework.TestCase;

public class Claims_Tags extends TestCase {
	public void claimTagTest() {
		Claim claim = new Claim("Beijing");
		claim.addTag("good");
		claim.findTag("good");
		assertTrue("Not the same claim",
				claim.findTag("good") == 1);
		claim.removeTag("good");
		assertTrue("Not the same claim",
				claim.findTag("good") == 0);
	}
	

	//u03.01.01	
	public void testAddTagAndDestination() {
	     ClaimList claimList = new ClaimList();
	      Claim claim = new Claim("test1",new ArrayList<Tag>(),new ArrayList<Destination>()); // claimName,tag,destination
	      
	        claim.getTagList().addTag(new Tag("testTag1"));                                 // add a test tag1
	        claim.getTagList().addTag(new Tag("testTag2"));                                 // add a test tag2
	        claim.getDestinations().addDestination.(new Destination("Edmonton","Study"));   // add a test destination with name and reason
	        claimList.addClaim(claim);                                                      // add the test claim

	        assertTrue("Adding Tag1 pass", ClaimList.get(0).getTagList().get(0).getTagName().equals("testTag1"));
	        assertTrue("Adding Tag2 pass", ClaimList.get(0).getTagList().get(1).getTagName().equals("testTag2"));
	        assertTrue("Adding Destination Name pass", ClaimList.get(0).getDestinations().get(0).getDestinationName().equals("Edmonton"));
	        assertTrue("Adding Destination Reason pass", ClaimList.get(0).getDestinations().get(0).getDestinationReason().equals("Study"));
	 }
	
	//u03.02.01
	public void testSortClaimList() {
        ClaimList claimList = new ClaimList();                        // create an empty claimList
        Claim claim = new Claim("Fail",new ArrayList<Tag>());         // claimName, tag
        Claim claim2 = new Claim("Pass",new ArrayList<Tag>());        // claimName, tag

        claim.getTagList().addTag(new Tag("testTag1"));               // add a test tag1
        claim.getTagList().addTag(new Tag("testTag2"));               // add a test tag2
        claim.getTagList().addTag(new Tag("testTag3"));               // add a test tag3
        claimList.addClaim(claim);                                    // add the test claim

        claim2.getTagList().addTag(new Tag("testTag1"));              // using for testing filter
        claim2.getTagList().addTag(new Tag("testTag2"));
        claimList.addClaim(claim2);

        // we do not need to test listing tags

        // test adding tag(s)
        assertTrue("Adding Tag1 pass", ClaimList.get(0).getTagList().get(0).getTagName().equals("testTag1"));
        assertTrue("Adding Tag2 pass", ClaimList.get(0).getTagList().get(1).getTagName().equals("testTag2"));
        assertTrue("Adding Tag3 pass", ClaimList.get(0).getTagList().get(2).getTagName().equals("testTag3"));

        // test renaming a tag
        Tag tag2 = claim.getTagList().get(1);
        tag2.setName("testTag0");
        assertTrue("Rename Tag2 pass", ClaimList.get(0).getTagList().get(1).getTagName().equals("testTag0"));

        // test deleting a tag
        claim.getTagList().deleteTag(2);
        assertTrue("Delete Tag3 pass", ClaimList.get(0).getTagList().get(2).getTagName() == null);       

        // test filter by tag
        ClaimList newClaimList1 = new ClaimList();
        ClaimList newClaimList2 = new ClaimList();

        for (int i = 0, i < claimList.size(), i++) {
            for (int j = 0, j < ClaimList.get(i).getTag().size(), j++) {
                if (ClaimList.get(i).getTag().get(j).equals("testTag1")) {
                    newClaimList1.addClaim(ClaimList.get(i));
                }
                else if (ClaimList.get(i).getTag().get(j).equals("testTag2")) {
                    newClaimList2.addClaim(ClaimList.get(i));
                }
            } 
        }

        assertTrue("Two Claims in newClaimList1", newClaimList.size() == 2);
        assertTrue("One Claims in newClaimList2", newClaimList.size() == 1); 
}

	//u03.03.01
	public void  testForFiliterTag(){
		
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
        claim.getTagList().addTag(new Tag("testTag1"));               // add a test tag1
        claim.getTagList().addTag(new Tag("testTag2"));               // add a test tag2
        claim.getTagList().addTag(new Tag("testTag3"));               // add a test tag3
        claimList.addClaim(claim);                                    // add the test claim

        claim2.getTagList().addTag(new Tag("testTag1"));              // using for testing filter
        claim2.getTagList().addTag(new Tag("testTag2"));
        claimList.addClaim(claim2);
		
        assertTrue("Adding Tag1 pass", ClaimList.get(0).getTagList().get(0).getTagName().equals("testTag1"));
        assertTrue("Adding Tag2 pass", ClaimList.get(0).getTagList().get(1).getTagName().equals("testTag2"));
        assertTrue("Adding Tag3 pass", ClaimList.get(0).getTagList().get(2).getTagName().equals("testTag3"));
        
        ClaimList tagClaimList = new ClaimList();
        
        Tag tag2 = new Tag();
        tag2.setName("testTag1");
        tagClaimList = tag2.getClaimList();
        assertEquals("Tag2 pass", tagClaimList,  testClaimList);
        
        ClaimList tag3ClaimList = new ClaimList();
        
        Tag tag3 = new Tag();
        tag3.setName("testTag3");
        tag3ClaimList = tag2.getClaimList();
        assertFalse("tag3 pass", tag3ClaimList.equals(testClaimList));
}
}
