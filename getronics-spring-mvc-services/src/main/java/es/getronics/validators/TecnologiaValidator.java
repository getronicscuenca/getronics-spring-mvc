package es.getronics.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.getronics.dto.TecnologiaDTO;

public class TecnologiaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TecnologiaDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TecnologiaDTO tecnologia = (TecnologiaDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombreVacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "descVacia");

		// nombre
		boolean nombreMuyLargo = tecnologia.getNombre().length() > 20;
		boolean nombreMuyCorto = (tecnologia.getNombre().length() == 1);

		if (nombreMuyLargo) {
			errors.rejectValue("nombre", "nombreLargo");
		}

		if (nombreMuyCorto) {
			errors.rejectValue("nombre", "nombreCorto");
		}

		// descripcion
		boolean DescMuyLarga = tecnologia.getDescripcion().length() > 30;
		boolean DescMuyCorta =  (tecnologia.getDescripcion().length() == 1);

		if (DescMuyLarga) {
			errors.rejectValue("descripcion", "descLarga");
		}
		if (DescMuyCorta) {
			errors.rejectValue("descripcion", "descCorta");
		}
	

	}

}
