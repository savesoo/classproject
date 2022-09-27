package chapter09;

public class User {
	
	public int UserIdx; // 외부에서 볼 수 있도록 public
	public String UserId;
	
	public User(int userIdx, String userId) {
		UserIdx = userIdx;
		UserId = userId;
	}

	public int getUserIdx() {
		return UserIdx;
	}

	public void setUserIdx(int userIdx) {
		UserIdx = userIdx;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}
	
	

}
