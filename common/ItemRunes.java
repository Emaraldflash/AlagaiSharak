package mods.AlagaiSharak.common;

public class ItemRunes extends MetaItemBase {
	
	public ItemRunes(int id, String[] names, String[] textures) {
		super(id, names, textures);
		
	}
	public static String texModifier = "AlagaiSharak" + ":";   
			  
			    public static String[] meta_names = new String[] {
			            "Rune0",
			            "Rune1",
			            "Rune2",
			            "Rune3",
			            "Rune4",
			            "Rune5",
			            "Rune6"
			    };
			    public static String[] meta_textures = new String[] {
			            texModifier + meta_names[0],
			            texModifier + meta_names[1],
			            texModifier + meta_names[2],
			            texModifier + meta_names[3],
			            texModifier + meta_names[4],
			            texModifier + meta_names[5],
			            texModifier + meta_names[6]
			    };

}
