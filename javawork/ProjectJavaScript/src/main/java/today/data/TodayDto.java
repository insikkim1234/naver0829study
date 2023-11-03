package today.data;

import java.sql.Timestamp;

public class TodayDto {
	private int num;
	private String login;
	private String github;
	private String naver;
	private String slack;
	private String googlenote;
	private String commit;
	private String logout;
	private Timestamp writeday;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getNaver() {
		return naver;
	}
	public void setNaver(String naver) {
		this.naver = naver;
	}
	public String getSlack() {
		return slack;
	}
	public void setSlack(String slack) {
		this.slack = slack;
	}
	public String getGooglenote() {
		return googlenote;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public void setGooglenote(String googlenote) {
		this.googlenote = googlenote;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		this.logout = logout;
	}
	
	
}
