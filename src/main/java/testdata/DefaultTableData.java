package testdata;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class DefaultTableData {
    @Singular
    List<String> headers;

    @Singular
    List<List<String>> rows;

    public static DefaultTableData defaultPeopleTable() {
        return DefaultTableData.builder()
                .header("#")
                .header("First")
                .header("Last")
                .header("Email")
                .row(List.of("1", "Mark", "Otto", "mo@email.com"))
                .row(List.of("2", "Jacob", "Thornton", "jacob_t@yahoo.com"))
                .row(List.of("3", "Larry", "Bow", "lbow@gmail.com"))
                .row(List.of("4", "Bobby", "Spencer", "bobby_23@gmail.com"))
                .row(List.of("5", "Mark", "Icarus", "el_icarus@yahoo.com"))
                .build();
    }
}
