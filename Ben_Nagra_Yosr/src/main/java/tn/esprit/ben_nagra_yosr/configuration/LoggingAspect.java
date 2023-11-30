package tn.esprit.ben_nagra_yosr.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
    //"execution(Modifiers-pattern? Ret-type-pattern Declaring-type-pattern?Name-pattern(param-pattern) Throws-pattern?)"
    //
    //• “?” veut dire optionnel
    //• Modifiers-pattern? : public, private ...
    //• Ret-type-pattern : le type de retour.
    //• Declaring-type-pattern? : nom de la classe y compris le package.
    //• Name-pattern : nom de la méthode.
    //• Throws-pattern? : l’exception.
    //• “..” veut dire, 0 ou plusieurs paramètres
    @Before("execution(* tn.esprit.ben_nagra_yosr.*.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After(" execution(* tn.esprit.ben_nagra_yosr.*.*.*(..)) ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("« Out of method " + name + " : ");
    }
//• @Before : Before advice : s’exécute avant le Join point. S’il lance une Exception, le Join point ne sera pas appelé.

//• @AfterReturning : After returning advice : s’exécute après le Join point, si celui-ci s’est bien exécuté (s’il n’y a pas d'Exception).

//• @AfterThrowing : After throwing advice : s’exécute si une Exception a été lancée pendant l’exécution du Join point.

//• @After : After advice : s’exécute après le Join point, qu’il y ait eu une Exception ou non.

//• @Around : Around advice : s’exécute autour du Join point. C’est l’advice le plus puissant.
}
