package pers.gg.yh.manager.common.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@MappedSuperclass
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
    private boolean status;
}
