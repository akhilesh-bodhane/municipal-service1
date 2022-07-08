package org.egov.sterilizationdog.repository.builder;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SterilizationDogQueryBuilder {
	
	public static final String GET_STERILIZATION_DOG_APPLICATION_QUERY = "SELECT SD.id, SD.app_id, SD.pick_sector, SD.pick_gender, SD.pick_houseno, SD.pick_latitude, SD.picklongitutde, SD.dog_color, SD.pick_type, SD.drop_sector, SD.drop_gender, SD.drop_houseno, SD.drop_latitude, SD.drop_longitutde, SD.pick, SD.release, SD.tenant_id, SD.created_by, SD.last_modified_by, SD.created_time, SD.last_modified_time, \r\n"
			+ "	 array_to_json(array_agg(json_build_object('documnetUuid',SP.document_uuid, 'pickfilestoreId',SP.pick_filestore_id,'pickpicture',SP.pick_picture, 'applicationUuid',SP.id, 'dropfilestoreId',SP.drop_filestore_id,'droppicture',SP.drop_picture, 'tenantId',SP.tenant_id,'isActive', SP.is_active))) as document \r\n"
			+ "	 FROM public.sterilization_dog_application_detail SD inner join sterilization_dog_application_document SP on SD.id=SP.id and SD.tenant_id=SP.tenant_id \r\n"
			+ "	 where pick=true and release=false and ((SD.created_time>=? or SD.created_time=? is null) and (SD.created_time<=? or SD.created_time=? is NULL)) \r\n"
			+ "  group by SD.id ORDER BY created_time desc ";
	
	
	public static final String GET_STERILIZATION_DOG_APPLICATION_ID_QUERY = "SELECT SD.id, SD.app_id, SD.pick_sector, SD.pick_gender, SD.pick_houseno, SD.pick_latitude, SD.picklongitutde, SD.dog_color, SD.pick_type, SD.drop_sector, SD.drop_gender, SD.drop_houseno, SD.drop_latitude, SD.drop_longitutde, SD.pick, SD.release, SD.tenant_id, SD.created_by, SD.last_modified_by, SD.created_time, SD.last_modified_time, \r\n"
			+ " array_to_json(array_agg(json_build_object('documnetUuid',SP.document_uuid, 'pickfilestoreId',SP.pick_filestore_id,'pickpicture',SP.pick_picture, 'applicationUuid',SP.id, 'dropfilestoreId',SP.drop_filestore_id,'droppicture',SP.drop_picture, 'tenantId',SP.tenant_id,'isActive', SP.is_active))) as document \r\n"
			+ "	FROM public.sterilization_dog_application_detail SD inner join sterilization_dog_application_document SP on SD.id=SP.id and SD.tenant_id=SP.tenant_id \r\n"
			+ "	 where (SD.app_id=? or SD.app_id=? is null) and ((SD.created_time>=? or SD.created_time=? is null) and (SD.created_time<=? or SD.created_time=? is NULL)) \r\n"
			+ "	group by SD.id ORDER BY created_time desc ";
	
	
	
}
