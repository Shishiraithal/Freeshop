package freeshop.model;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import com.google.appengine.api.datastore.Text;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

@Convert(Text.class)
@ApplicationScoped
public class TextConverter implements Converter<Text> {

	@Override
	public Text convert(String value, Class<? extends Text> type, ResourceBundle bundle) {
		
		if (value == null ) {
			return null;
		}
		
		try {
			return new Text(value);
			
		} catch (Exception e) {
			throw new ConversionError(MessageFormat.format(bundle.getString("error.text.conversion"), value));
		}
	}

}
