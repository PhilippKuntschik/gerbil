package org.aksw.gerbil.datasets;

import it.acubelab.batframework.datasetPlugins.MeijDataset;
import it.acubelab.batframework.problems.TopicDataset;

import java.io.IOException;

import org.aksw.gerbil.GerbilConfiguration;
import org.aksw.gerbil.datatypes.ExperimentType;

public class MeijDatasetConfig extends AbstractDatasetConfiguration {

    private static final String MEIJ_TWEETS_FILE_PROPERTY_NAME = "org.aksw.gerbil.datasets.IITBDatasetConfig.TweetsFile";
    private static final String MEIJ_ANNOTATIONS_FILE_PROPERTY_NAME = "org.aksw.gerbil.datasets.IITBDatasetConfig.AnnotationsFile";
    private static final String MEIJ_RANK_FILE_PROPERTY_NAME = "org.aksw.gerbil.datasets.IITBDatasetConfig.RankFile";

    public MeijDatasetConfig() {
        super("Meij", true, ExperimentType.Rc2W);
    }

    @Override
    protected TopicDataset loadDataset() throws Exception {
        String tweetsFile = GerbilConfiguration.getInstance().getString(MEIJ_TWEETS_FILE_PROPERTY_NAME);
        if (tweetsFile == null) {
            throw new IOException("Couldn't load needed Property \"" + MEIJ_TWEETS_FILE_PROPERTY_NAME + "\".");
        }
        String tagsFile = GerbilConfiguration.getInstance().getString(MEIJ_ANNOTATIONS_FILE_PROPERTY_NAME);
        if (tagsFile == null) {
            throw new IOException("Couldn't load needed Property \"" + MEIJ_ANNOTATIONS_FILE_PROPERTY_NAME + "\".");
        }
        String rankFile = GerbilConfiguration.getInstance().getString(MEIJ_RANK_FILE_PROPERTY_NAME);
        if (rankFile == null) {
            throw new IOException("Couldn't load needed Property \"" + MEIJ_RANK_FILE_PROPERTY_NAME + "\".");
        }
        return new MeijDataset(tweetsFile, tagsFile, rankFile);
    }

}
