import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App {

	public static void main(String[] args) {
		
		// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		LocalDate d01 = LocalDate.parse("2022-07-20");
		LocalDateTime d02 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d03 = Instant.parse("2022-07-20T01:30:26Z");
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		// Este é obrigatório apenas em casos de objetos Instant.
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault()); // .withZone = da zona/fuso, ZoneId.systemDefault = fuso do sistema.
		
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME; // ISO_DATE_TIME = imprime no formato ISO.
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT; // ISO_INSTANT = imprime no formato ISO com fuso UTC.
		
		System.out.println("d01 = " + d01.format(fmt1)); // .format permite usar o padrão do DateTimeFormatter.
		System.out.println("d01 = " + fmt1.format(d01)); // chamei o objeto a partir do DateTimeFormatter.
		System.out.println("d01 = " + d01.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // outro jeito de conversão.
		
		System.out.println("d02 = " + d02.format(fmt1)); // d02 no formato fmt1.
		System.out.println("d02 = " + d02.format(fmt2)); // d02 no formato fmt2.
		System.out.println("d02 = " + d02.format(fmt4)); // d02 no formato fmt4.
		
		// Instant não tem o método format.
		System.out.println("d03 = " + fmt3.format(d03)); // Chama-se a partir do objeto, pois o instant não tem o método format.
		System.out.println("d03 = " + fmt5.format(d03));
		
		
	}

}
