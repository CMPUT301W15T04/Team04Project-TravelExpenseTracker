package ca.ualberta.cs.cmput301w15t04team04project.CLmanager;

import java.io.IOException;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
/**
* The ClaimListController is the controller for ClaimList and MyClaims
*
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-11
*/

public class ClaimListController {
	// Lazy Singleton
		private static ClaimList claimList = null;

		static public ClaimList getClaimList() {
/*			if (claimList == null) {
				try {
					claimList = ClaimListManager.getManager().loadClaimList();
					claimList.addListener(new Listener() {
						@Override
						public void update() {
							saveClaimList();
						}
					});
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(
							"Could not deserialize ClaimList from ClaimListManager");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(
							"Could not deserialize ClaimList from ClaimListManager");
				}
			}*/
			return claimList;
		}


		public void addClaim(Claim claim) {
			// TODO Auto-generated method stub
			getClaimList().addClaim(claim);
		}

		static public void saveClaimList() {
/*			try {
				ClaimListManager.getManager().saveClaimList(getClaimList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(
						"Could not deserialize StudentList from StudentListManager");
			}*/
		}
}
