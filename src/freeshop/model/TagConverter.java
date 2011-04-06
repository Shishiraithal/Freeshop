package freeshop.model;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

@Convert(Tag[].class)
@ApplicationScoped
public class TagConverter implements Converter<Tag[]> {

	@Override
	public Tag[] convert(String value, Class<? extends Tag[]> type, ResourceBundle bundle) {
		
		if (value == null || value.trim().equals("")) {
			return null;
		}
		try {
			value = value.trim().toLowerCase();
			String[] tagNames = value.split(",");
			
			Tag[] tags = new Tag[tagNames.length];
			for( int i=0; i<tags.length; i++ ) {
				tags[i] = new Tag( tagNames[i].trim() );
			}
			
			return tags;
			
		} catch (Exception e) {
			throw new ConversionError(MessageFormat.format(bundle.getString("error.tag.conversion"), value));
		}
	}

}
