package com.archermind.ashare.render.service;

import java.util.ArrayList;

import org.teleal.cling.support.connectionmanager.ConnectionManagerService;
import org.teleal.cling.support.model.ProtocolInfo;
import org.teleal.common.util.MimeType;

public class AShareConnectionManagerService extends ConnectionManagerService {
	private final static boolean DEBUG = true;
	protected final static ArrayList<MimeType> sSupportFormats = new ArrayList<MimeType>();
    static {
        sSupportFormats.clear();

        /** MIME Type for video formats */
        sSupportFormats.add(new MimeType("video", "3gpp"));
        sSupportFormats.add(new MimeType("video", "mpeg"));
        sSupportFormats.add(new MimeType("video", "mkv"));
        sSupportFormats.add(new MimeType("video", "mpg"));
        sSupportFormats.add(new MimeType("video", "avi"));
        sSupportFormats.add(new MimeType("video", "mp4"));
        sSupportFormats.add(new MimeType("video", "flv"));
        sSupportFormats.add(new MimeType("video", "x-matroska"));
        sSupportFormats.add(new MimeType("video", "x-ms-wmv"));
        sSupportFormats.add(new MimeType("video", "x-ms-asf"));
        sSupportFormats.add(new MimeType("video", "x-msvideo"));

        /** MIME Type for audio formats */
        sSupportFormats.add(new MimeType("audio", "amr-wb"));
        sSupportFormats.add(new MimeType("audio", "mpeg"));
        sSupportFormats.add(new MimeType("audio", "amr"));
        sSupportFormats.add(new MimeType("audio", "aac"));
        sSupportFormats.add(new MimeType("audio", "midi"));
        sSupportFormats.add(new MimeType("audio", "flac"));
        sSupportFormats.add(new MimeType("audio", "mp4"));
        sSupportFormats.add(new MimeType("audio", "x-ms-wma"));
        sSupportFormats.add(new MimeType("audio", "x-wav"));

        /** MIME Type for image formats */
        sSupportFormats.add(new MimeType("image", "jpeg"));
        sSupportFormats.add(new MimeType("image", "png"));
        sSupportFormats.add(new MimeType("image", "gif"));
        sSupportFormats.add(new MimeType("image", "bmp"));
        sSupportFormats.add(new MimeType("image", "x-ms-bmp"));
        sSupportFormats.add(new MimeType("image", "vnd.wap.wbmp"));
    }
    public AShareConnectionManagerService() {
        for (MimeType mt : sSupportFormats) {
            try {
                LogUtil.logv(this, "Supported MIME type: " + mt,DEBUG);
                sinkProtocolInfo.add(new ProtocolInfo(mt));
            } catch (IllegalArgumentException ex) {
                LogUtil.logv(this, "Ignoring invalid MIME type: " + mt,DEBUG);
            }
        }
        LogUtil.logv(this, "Supported MIME types: " + sinkProtocolInfo.size(),DEBUG);
    }
}
