/*
 * 	This file is part of DicomFlow.
 * 
 * 	DicomFlow is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 * 
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 * 
 * 	You should have received a copy of the GNU General Public License
 * 	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package br.ufpb.dicomflow.mocks;

import java.util.Date;
import java.util.Set;

public class Study {
	
	
	private static final long serialVersionUID = 8327591947346455289L;
	
	private Long id; 
	
	private Patient patient;
	
	private Set<Series> series;

	private String studyIuid;
	
	private String studyId;
	
	private Date studyDateTime;
	
	private String accessionNumber;
	
	private String modalitiesInStudy;
	
	private String sopClassesInStudy;
	
	private Integer numberOfStudyRelatedSeries;
	
	private Integer numberOfStudyRelatedInstances;
	
	private String retrieveAETs;
		
	private Integer availability;
		
    private Integer studyStatus;
		
    private Date updatedTime;
	
    private Date createdTime;
	
	private byte[] encodedAttributes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Set<Series> getSeries() {
		return series;
	}

	public void setSeries(Set<Series> series) {
		this.series = series;
	}

	public String getStudyIuid() {
		return studyIuid;
	}

	public void setStudyIuid(String studyIuid) {
		this.studyIuid = studyIuid;
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public Date getStudyDateTime() {
		return studyDateTime;
	}

	public void setStudyDateTime(Date studyDateTime) {
		this.studyDateTime = studyDateTime;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getModalitiesInStudy() {
		return modalitiesInStudy;
	}

	public void setModalitiesInStudy(String modalitiesInStudy) {
		this.modalitiesInStudy = modalitiesInStudy;
	}

	public String getSopClassesInStudy() {
		return sopClassesInStudy;
	}

	public void setSopClassesInStudy(String sopClassesInStudy) {
		this.sopClassesInStudy = sopClassesInStudy;
	}

	public Integer getNumberOfStudyRelatedSeries() {
		return numberOfStudyRelatedSeries;
	}

	public void setNumberOfStudyRelatedSeries(Integer numberOfStudyRelatedSeries) {
		this.numberOfStudyRelatedSeries = numberOfStudyRelatedSeries;
	}

	public Integer getNumberOfStudyRelatedInstances() {
		return numberOfStudyRelatedInstances;
	}

	public void setNumberOfStudyRelatedInstances(Integer numberOfStudyRelatedInstances) {
		this.numberOfStudyRelatedInstances = numberOfStudyRelatedInstances;
	}

	public String getRetrieveAETs() {
		return retrieveAETs;
	}

	public void setRetrieveAETs(String retrieveAETs) {
		this.retrieveAETs = retrieveAETs;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Integer getStudyStatus() {
		return studyStatus;
	}

	public void setStudyStatus(Integer studyStatus) {
		this.studyStatus = studyStatus;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public byte[] getEncodedAttributes() {
		return encodedAttributes;
	}

	public void setEncodedAttributes(byte[] encodedAttributes) {
		this.encodedAttributes = encodedAttributes;
	}
	
	
	
	
}	
	
	