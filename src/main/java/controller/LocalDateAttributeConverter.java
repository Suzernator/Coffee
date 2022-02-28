/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 24, 2022
 */

package controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date>{
		
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return (attribute == null ? null: Date.valueOf(attribute));
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return (dbData == null ? null: dbData.toLocalDate());
	}

}
