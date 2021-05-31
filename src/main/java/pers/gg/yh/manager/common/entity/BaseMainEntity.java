package pers.gg.yh.manager.common.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class BaseMainEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "id_sequence")
    @GenericGenerator(name = "id_sequence", strategy = "pers.gg.yh.manager.common.generator.IdGenerator")
    private String id;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private int version;
    private String refNo;
    private boolean latest;
}
