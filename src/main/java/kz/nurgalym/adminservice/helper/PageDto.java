package kz.nurgalym.adminservice.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto<T> {
    private long recordCount;
    private long pageCount;
    private int pageSize;
    private int pageNumber;
    private List<T> records;
}

