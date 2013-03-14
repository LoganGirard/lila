package lila.api
package cli

import lila.api.ApiEnv

import play.api.libs.concurrent.Execution.Implicits._

object Cli {

  def main(env: ApiEnv)(args: Array[String]): Fu[String] = (args.toList match {
    // case "average-elo" :: Nil               ⇒ infos.averageElo
    // case "i18n-js-dump" :: Nil              ⇒ i18n.jsDump
    // case "i18n-fix" :: Nil                  ⇒ i18n.fileFix
    // case "i18n-fetch" :: from :: Nil        ⇒ i18n fetch from
    // case "user-enable" :: uid :: Nil        ⇒ users enable uid
    // case "user-disable" :: uid :: Nil       ⇒ users disable uid
    // case "user-passwd" :: uid :: pwd :: Nil ⇒ users.passwd(uid, pwd)
    // case "user-roles" :: uid :: Nil         ⇒ users roles uid
    // case "user-grant" :: uid :: roles       ⇒ users.grant(uid, roles)
    // case "user-rewrite-history" :: Nil      ⇒ users.rewriteHistory
    // case "forum-denormalize" :: Nil         ⇒ forum.denormalize
    // case "forum-typecheck" :: Nil           ⇒ forum.typecheck
    // case "forum-search" :: text :: Nil      ⇒ forum.search(text)
    // case "forum-search-reset" :: Nil        ⇒ forum.searchReset
    // case "game-cleanup-next" :: Nil         ⇒ titivate.cleanupNext inject "Done"
    // case "game-cleanup-unplayed" :: Nil     ⇒ titivate.cleanupUnplayed inject "Done"
    // case "game-finish" :: Nil               ⇒ titivate.finishByClock inject "Done"
    // case "game-per-day" :: Nil              ⇒ games.perDay(30)
    // case "game-per-day" :: days :: Nil      ⇒ games.perDay(parseIntOption(days) err "days: Int")
    case "wiki-fetch" :: Nil ⇒ env.wiki.cli.fetch
    // case "search-reset" :: Nil              ⇒ search.reset
    // case "team-search" :: text :: Nil       ⇒ teams.search(text)
    // case "team-search-reset" :: Nil         ⇒ teams.searchReset
    // case "team-join" :: team :: users       ⇒ teams.join(team, users)
    // case "team-quit" :: team :: users       ⇒ teams.quit(team, users)
    // case "team-enable" :: uid :: Nil        ⇒ teams enable uid
    // case "team-disable" :: uid :: Nil       ⇒ teams disable uid
    // case "team-delete" :: uid :: Nil        ⇒ teams delete uid
    case _                   ⇒ fuccess("Unknown command: " + args.mkString(" "))
  }) ~ {
    _ onSuccess { case output ⇒ println("[cli] %s\n".format(args mkString " ", output)) }
  }

}
