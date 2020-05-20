package bg.unwe.saasbackend.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {


    public LocalDateTimeConverter() {
    }

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime ==null ? null : Timestamp.valueOf(localDateTime);
    }
    //TODO: new Timestamp(10L) is just for testing
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp ==null ? null : timestamp.toLocalDateTime();
    }
}
