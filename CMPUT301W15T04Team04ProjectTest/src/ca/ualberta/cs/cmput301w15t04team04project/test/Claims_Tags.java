package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import junit.framework.TestCase;

public class Claims_Tags extends TestCase {
	public void claimTagTest() {
		Claim claim = new Claim("Beijing");
		claim.addTag("good");
		claim.findTag("good");
		claim.removeTag("good");
		claim.findTag("good");
	}
}
