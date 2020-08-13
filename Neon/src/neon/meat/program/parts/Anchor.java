package neon.meat.program.parts;

public class Anchor extends ExecutableLine{

	private String AnchorName;
	private int Position;
	
	public Anchor(String AnchorName, int Position) {
		type = 0;
		this.AnchorName = AnchorName;
		this.Position = Position;
	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
	}
	
	public String getAnchorName() {
		return AnchorName;
	}

	public int getPosition() {
		return Position;
	}
	
}
