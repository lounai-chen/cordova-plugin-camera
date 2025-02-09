package org.apache.cordova.camera;

import androidx.exifinterface.media.ExifInterface;

//import com.getcapacitor.JSObject;

import static androidx.exifinterface.media.ExifInterface.*;

public class ExifWrapper {

    private final ExifInterface exif;
    private final String[] attributes = new String[] {
        TAG_APERTURE_VALUE,
        TAG_ARTIST,
        TAG_BITS_PER_SAMPLE,
        TAG_BODY_SERIAL_NUMBER,
        TAG_BRIGHTNESS_VALUE,
        //TAG_CAMERA_OWNER_NAME,
        TAG_CFA_PATTERN,
        TAG_COLOR_SPACE,
        TAG_COMPONENTS_CONFIGURATION,
        TAG_COMPRESSED_BITS_PER_PIXEL,
        TAG_COMPRESSION,
        TAG_CONTRAST,
        TAG_COPYRIGHT,
        TAG_CUSTOM_RENDERED,
        TAG_DATETIME,
        TAG_DATETIME_DIGITIZED,
        TAG_DATETIME_ORIGINAL,
        TAG_DEFAULT_CROP_SIZE,
        TAG_DEVICE_SETTING_DESCRIPTION,
        TAG_DIGITAL_ZOOM_RATIO,
        TAG_DNG_VERSION,
        TAG_EXIF_VERSION,
        TAG_EXPOSURE_BIAS_VALUE,
        TAG_EXPOSURE_INDEX,
        TAG_EXPOSURE_MODE,
        TAG_EXPOSURE_PROGRAM,
        TAG_EXPOSURE_TIME,
        TAG_FILE_SOURCE,
        TAG_FLASH,
        TAG_FLASHPIX_VERSION,
        TAG_FLASH_ENERGY,
        TAG_FOCAL_LENGTH,
        TAG_FOCAL_LENGTH_IN_35MM_FILM,
        TAG_FOCAL_PLANE_RESOLUTION_UNIT,
        TAG_FOCAL_PLANE_X_RESOLUTION,
        TAG_FOCAL_PLANE_Y_RESOLUTION,
        TAG_F_NUMBER,
        TAG_GAIN_CONTROL,
        TAG_GAMMA,
        TAG_GPS_ALTITUDE,
        TAG_GPS_ALTITUDE_REF,
        TAG_GPS_AREA_INFORMATION,
        TAG_GPS_DATESTAMP,
        TAG_GPS_DEST_BEARING,
        TAG_GPS_DEST_BEARING_REF,
        TAG_GPS_DEST_DISTANCE,
        TAG_GPS_DEST_DISTANCE_REF,
        TAG_GPS_DEST_LATITUDE,
        TAG_GPS_DEST_LATITUDE_REF,
        TAG_GPS_DEST_LONGITUDE,
        TAG_GPS_DEST_LONGITUDE_REF,
        TAG_GPS_DIFFERENTIAL,
        TAG_GPS_DOP,
        TAG_GPS_H_POSITIONING_ERROR,
        TAG_GPS_IMG_DIRECTION,
        TAG_GPS_IMG_DIRECTION_REF,
        TAG_GPS_LATITUDE,
        TAG_GPS_LATITUDE_REF,
        TAG_GPS_LONGITUDE,
        TAG_GPS_LONGITUDE_REF,
        TAG_GPS_MAP_DATUM,
        TAG_GPS_MEASURE_MODE,
        TAG_GPS_PROCESSING_METHOD,
        TAG_GPS_SATELLITES,
        TAG_GPS_SPEED,
        TAG_GPS_SPEED_REF,
        TAG_GPS_STATUS,
        TAG_GPS_TIMESTAMP,
        TAG_GPS_TRACK,
        TAG_GPS_TRACK_REF,
        TAG_GPS_VERSION_ID,
        TAG_IMAGE_DESCRIPTION,
        TAG_IMAGE_LENGTH,
        TAG_IMAGE_UNIQUE_ID,
        TAG_IMAGE_WIDTH,
        TAG_INTEROPERABILITY_INDEX,
        TAG_ISO_SPEED,
        TAG_ISO_SPEED_LATITUDE_YYY,
        TAG_ISO_SPEED_LATITUDE_ZZZ,
        TAG_JPEG_INTERCHANGE_FORMAT,
        TAG_JPEG_INTERCHANGE_FORMAT_LENGTH,
        TAG_LENS_MAKE,
        TAG_LENS_MODEL,
        TAG_LENS_SERIAL_NUMBER,
        TAG_LENS_SPECIFICATION,
        TAG_LIGHT_SOURCE,
        TAG_MAKE,
        TAG_MAKER_NOTE,
        TAG_MAX_APERTURE_VALUE,
        TAG_METERING_MODE,
        TAG_MODEL,
        TAG_NEW_SUBFILE_TYPE,
        TAG_OECF,
       // TAG_OFFSET_TIME,
       // TAG_OFFSET_TIME_DIGITIZED,
       // TAG_OFFSET_TIME_ORIGINAL,
        TAG_ORF_ASPECT_FRAME,
        TAG_ORF_PREVIEW_IMAGE_LENGTH,
        TAG_ORF_PREVIEW_IMAGE_START,
        TAG_ORF_THUMBNAIL_IMAGE,
        TAG_ORIENTATION,
        TAG_PHOTOGRAPHIC_SENSITIVITY,
        TAG_PHOTOMETRIC_INTERPRETATION,
        TAG_PIXEL_X_DIMENSION,
        TAG_PIXEL_Y_DIMENSION,
        TAG_PLANAR_CONFIGURATION,
        TAG_PRIMARY_CHROMATICITIES,
        TAG_RECOMMENDED_EXPOSURE_INDEX,
        TAG_REFERENCE_BLACK_WHITE,
        TAG_RELATED_SOUND_FILE,
        TAG_RESOLUTION_UNIT,
        TAG_ROWS_PER_STRIP,
        TAG_RW2_ISO,
        TAG_RW2_JPG_FROM_RAW,
        TAG_RW2_SENSOR_BOTTOM_BORDER,
        TAG_RW2_SENSOR_LEFT_BORDER,
        TAG_RW2_SENSOR_RIGHT_BORDER,
        TAG_RW2_SENSOR_TOP_BORDER,
        TAG_SAMPLES_PER_PIXEL,
        TAG_SATURATION,
        TAG_SCENE_CAPTURE_TYPE,
        TAG_SCENE_TYPE,
        TAG_SENSING_METHOD,
        TAG_SENSITIVITY_TYPE,
        TAG_SHARPNESS,
        TAG_SHUTTER_SPEED_VALUE,
        TAG_SOFTWARE,
        TAG_SPATIAL_FREQUENCY_RESPONSE,
        TAG_SPECTRAL_SENSITIVITY,
        TAG_STANDARD_OUTPUT_SENSITIVITY,
        TAG_STRIP_BYTE_COUNTS,
        TAG_STRIP_OFFSETS,
        TAG_SUBFILE_TYPE,
        TAG_SUBJECT_AREA,
        TAG_SUBJECT_DISTANCE,
        TAG_SUBJECT_DISTANCE_RANGE,
        TAG_SUBJECT_LOCATION,
        TAG_SUBSEC_TIME,
        TAG_SUBSEC_TIME_DIGITIZED,
        TAG_SUBSEC_TIME_ORIGINAL,
        TAG_THUMBNAIL_IMAGE_LENGTH,
        TAG_THUMBNAIL_IMAGE_WIDTH,
        TAG_TRANSFER_FUNCTION,
        TAG_USER_COMMENT,
        TAG_WHITE_BALANCE,
        TAG_WHITE_POINT,
       // TAG_XMP,
        TAG_X_RESOLUTION,
        TAG_Y_CB_CR_COEFFICIENTS,
        TAG_Y_CB_CR_POSITIONING,
        TAG_Y_CB_CR_SUB_SAMPLING,
        TAG_Y_RESOLUTION
    };

    public ExifWrapper(ExifInterface exif) {
        this.exif = exif;
    }

//    public JSObject toJson() {
//        JSObject ret = new JSObject();
//
//        if (this.exif == null) {
//            return ret;
//        }
//
//        for (int i = 0; i < attributes.length; i++) {
//            p(ret, attributes[i]);
//        }
//
//        return ret;
//    }
//
//    public void p(JSObject o, String tag) {
//        String val = exif.getAttribute(tag);
//        o.put(tag, val);
//    }

    public void copyExif(String destFile) {
        try {
            ExifInterface destExif = new ExifInterface(destFile);
            for (int i = 0; i < attributes.length; i++) {
                String value = exif.getAttribute(attributes[i]);
                if (value != null) {
                    destExif.setAttribute(attributes[i], value);
                }
            }
            destExif.saveAttributes();
        } catch (Exception ex) {}
    }

    public void resetOrientation() {
        exif.resetOrientation();
    }
}
