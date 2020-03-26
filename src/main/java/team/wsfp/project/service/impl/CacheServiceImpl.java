package team.wsfp.project.service.impl;

import org.springframework.stereotype.Service;
import team.wsfp.project.domain.cache.ProblemScore;
import team.wsfp.project.service.CacheService;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService {

    private static final String KEY_SCORE = "sysScore";

    private static final String KEY_PRO_NUM = "problemNum";

    private List<ProblemScore> scoreList = new ArrayList<>();
    private WeakReference<List<ProblemScore>> weakScoreList = new WeakReference<>(scoreList);

    @Override
    public void addProblemScore(Map<String, Object> map) {
        weakScoreList.get().add(
                new ProblemScore((int) map.get(KEY_SCORE), (int) map.get(KEY_PRO_NUM))
        );
    }
}
