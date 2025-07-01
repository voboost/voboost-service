# Consumer ProGuard rules for voboost-service library

# Keep public API classes
-keep public class ru.voboost.service.VoboostService { *; }
-keep public class ru.voboost.service.VoboostServiceBinder { *; }

# Keep vehicle integration interfaces
-keep public interface ru.voboost.service.vehicle.** { *; }

# Keep configuration models
-keep public class ru.voboost.service.model.** { *; }

# Keep result classes
-keep public class ru.voboost.service.Result { *; }
-keep public class ru.voboost.service.Result$* { *; }