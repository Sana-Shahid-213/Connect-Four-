package sanatorium;

public class Token {
	//properties of tokens
	//water
	//private String tokenColour;
	private String imageName;
	


public Token(String tokenColour) {
	if (tokenColour == "red") {
		//define as red token image
		imageName = "redtoken";
	}else if (tokenColour == "yellow"){
		//define as yellow token image
		imageName = "yellowtoken";
	}
}
}

