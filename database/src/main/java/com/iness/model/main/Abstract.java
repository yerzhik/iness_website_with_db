package com.iness.model.main;

import com.iness.dao.hibernate.HibernateUtil;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the bb_common_game_data database table.
 * 
 */
@Entity
@Table(name="bb_abstracts")
@DynamicUpdate
@NamedQueries({
        @NamedQuery(name= Abstract.GET_ALL_ABSTRACTS, query="SELECT abstract FROM Abstract abstract"),
        @NamedQuery(name= Abstract.GET_ALL_ABSTRACTS_BY_TYPE, query="SELECT abstract FROM Abstract abstract WHERE isOral=:value")
})
public class Abstract implements Serializable {
	
	private static final long serialVersionUID = 4593064032460309088L;
	public static final String GET_ALL_ABSTRACTS = "Abstract:SelectAllAbstracts";
    public static final String GET_ALL_ABSTRACTS_BY_TYPE = "Abstract:GET_ALL_ABSTRACTS_BY_TYPE";
    private Integer id;
    private String numeration;
    private String author;
    private String topic;
    private Boolean isOral;
    private String startDay;
    private String startTime;
    private String roomNumber;
    private String abstractText;
    private String img;

    public Abstract() {
	}


	@Id
	@SequenceGenerator(name="BB_ABSTRACTS_ID_GENERATOR", sequenceName="BB_ABSTRACTS_ID_SEQ", allocationSize=HibernateUtil.ALLOCATION_SIZE)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BB_ABSTRACTS_ID_GENERATOR")
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    @Column(name="numeration")
    public String getNumeration() {
        return numeration;
    }

    public void setNumeration(String numeration) {
        this.numeration = numeration;
    }

    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name="topic")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(name="is_oral")
    public Boolean getIsOral() {
        return isOral;
    }

    public void setIsOral(Boolean oral) {
        isOral = oral;
    }

    @Column(name="start_day")
    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    @Column(name="start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Column(name="room_number")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name="abstract_text")
    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    @Column(name="img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}