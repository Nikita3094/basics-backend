package org.example.basics.filecopy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CopyRequest {

    private String sourcePath;
    private String destinationPath;
}
