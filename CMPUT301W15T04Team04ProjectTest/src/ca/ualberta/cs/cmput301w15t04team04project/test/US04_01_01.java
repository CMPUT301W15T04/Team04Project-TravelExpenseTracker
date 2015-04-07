package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import junit.framework.TestCase;

public class US04_01_01 extends ActivityInstrumentationTestCase2<EditClaimActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	public User claimiant;

	public US04_01_01(Class<EditClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

}
